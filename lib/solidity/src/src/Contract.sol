// SPDX-License-Identifier: UNLICENSED
// To solve this challenge you should NOT change solidity version
pragma solidity 0.6.0;

contract Contract {
    int32 public account_balance = 0;

    function depost(int32 value) public {
        account_balance += value;
    }
}
