package main

import (
	"fmt"
)

const threshold = 248 * 86400 * 100

func main() {
	fmt.Println("[!] Welcome to Boeing 787!")
	fmt.Println("[?] Please enter how many days this Boeing has been online [1-248]: ")
	var days int32
	fmt.Scanln(&days)
	res, _ := requireReboot(days)
	if res {
		fmt.Printf("[!] Reboot is required\n")
	} else {
		fmt.Printf("[i] System is optimal\n")
		fmt.Printf("[i] Reboot is required in %d days\n", 248-days)

	}
}

func requireReboot(days int32) (bool, error) {
	check := days * 86400 * 100
	if check >= threshold {
		return true, nil
	}
	return false, nil
}