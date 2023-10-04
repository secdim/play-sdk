// SPDX-License-Identifier: UNLICENSED
pragma solidity 0.6.0;

import "forge-std/Test.sol";
import "../src/Contract.sol";

contract ContractTest is Test {
    Contract c;

    function setUp() public {
        c = new Contract();
    }

    function testDeposit() public {
        c.depost(100);
        assertEq(c.account_balance(), 100);
    }

    function testTwoDeposits_Addsup() public {
        c.depost(100);
        c.depost(100);
        assertEq(c.account_balance(), 200);
    }
}
