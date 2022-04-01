package main

import (
	"fmt"
	"time"
)

func main() {
	primes := calcPrimes()
	fmt.Printf("Found primes count: %d\n", len(primes))
	fmt.Println("Last 3 Primes: ")
	fmt.Println(primes[len(primes)-1])
	fmt.Println(primes[len(primes)-2])
	fmt.Println(primes[len(primes)-3])
}

func calcPrimes() (primes []int) {
	timeLimit := time.Now().UnixMilli() + 1000
	primes = make([]int, 1)
	primes[0] = 2

	potentialPrime := 3
	for time.Now().UnixMilli() <= timeLimit {
		potentialDiv := 3
		maxPotentialDiv := potentialPrime / 3

		isPrime := true

		for potentialDiv <= maxPotentialDiv {
			if potentialPrime%potentialDiv == 0 {
				isPrime = false
				break
			}
			potentialDiv += 2
		}

		if isPrime {
			primes = append(primes, potentialPrime)
		}

		potentialPrime += 2
	}
	return
}

//Found primes count: 26700
//Last 3 Primes:
//308713
//308701
//308681

// Validated count with https://www.dcode.fr/prime-number-pi-count
// TODO in parallell?
// Help: https://gobyexample.com/for
