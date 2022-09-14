package main

import (
	"testing"
)

func Test100DaysIsSystemOptimal(t *testing.T) {
	res, _ := requireReboot(100)
	if res != false {
		t.Errorf("Got: %t, want: %t", res, false)
	}
}

func Test248DaysRequiresReboot(t *testing.T) {
	res, _ := requireReboot(248)
	if res != true {
		t.Errorf("Got: %t, want: %t", res, true)
	}
}