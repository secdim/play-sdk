// SPDX-License-Identifier: UNLICENSED
pragma solidity 0.6.0;

import "forge-std/Script.sol";

contract ContractScript is Script {
    function setUp() public {}

    function run() public {
        vm.broadcast();
    }
}
