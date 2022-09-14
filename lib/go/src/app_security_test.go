package main

import (
	"testing"
	"fmt"
	"math"
)

func Test249DaysRequiresReboot(t *testing.T) {
	res, _ := requireReboot(249)
	if res != true {
		t.Errorf("It requires reboot")
	}
}

func TestMAXIntValueRequiresReboot(t *testing.T) {
	res, _ := requireReboot(math.MaxInt32)
	if res != true {
		t.Errorf("It requires reboot")
	}
}

func TestZeroShouldReturnError(t *testing.T) {
	_, err := requireReboot(0)
	if err == nil {
		t.Errorf("Raise error when input 0")
	}
}

func TestNegativeShouldReturnError(t *testing.T) {
	_, err := requireReboot(-1)
	if err == nil {
		t.Errorf("Raise error when input negative value")
	}
}


func TestNullShouldReturnError(t *testing.T) {
	var i int32
	val,_ := fmt.Scanf("%d", &i)
	_, err := requireReboot(int32(val))
	if err == nil {
		t.Errorf("Raise error when input null")
	}
}