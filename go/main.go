package main

import (
	"fmt"
	"time"
)

func printRange(start, end int64) {
	for i := start; i <= end; i++ {
		fmt.Println(i)
	}
}

func main() {
	var maxNum int64 = 50_000_000
	var numGoRoutines int64 = 10000
	rangePerGoRoutine := maxNum / numGoRoutines

	inicio := time.Now()

	for i := int64(0); i < numGoRoutines; i++ {
		start := i*rangePerGoRoutine + 1
		end := rangePerGoRoutine * (i + 1)
		if i == numGoRoutines-1 {
			end = maxNum
		}
		go printRange(start, end)
	}

	fmt.Printf("tiempo %v\n", time.Since(inicio))
}
