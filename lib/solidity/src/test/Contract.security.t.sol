// SPDX-License-Identifier: UNLICENSED
pragma solidity 0.6.0;

import "forge-std/Test.sol";
import "../src/Contract.sol";

contract ContractTest is Test {
    Contract c;

    function setUp() public {
        c = new Contract();
    }

    function testMultipleDeposit_DoesNotOverflow() public {
        c.depost(2147483640);
        vm.expectRevert();
        c.depost(10);
    }

  
}
