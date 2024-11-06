// SPDX-License-Identifier: GPL-3.0

pragma solidity >=0.7.0 <0.9.0;

contract Bank {
    
    mapping(address=>uint) private balances;
    
    function getBalance() public view returns (uint) {
        return balances[msg.sender];
    }

    function deposit(uint amount) public payable {
        // require(msg.value == amount);
        balances[msg.sender] += amount;
    }

    function withdraw(uint amount) public payable {
        require(amount <= balances[msg.sender]);
        balances[msg.sender] -= amount;
        // msg.sender.transfer(amount);
    }

}













/*// SPDX-License-Identifier: MIT
pragma solidity 0.8.26;

contract DBank{
    
    address Owner;

    mapping (address=>uint)Balance;
    constructor(){
        Owner=msg.sender;
    }

    function AddBalance(uint amount) public returns (uint){
        require(Owner==msg.sender, "You Can not  Transfer the Amount");
        Balance[msg.sender]+=amount;
        return Balance[msg.sender];
    }

    function GetBalance() public view returns (uint)
    {
        return Balance[msg.sender];
    }

    function Transfer(address recipient,uint amount) public 
    {
        require(msg.sender!=recipient,"can't transfer the  Amount");
        require(Balance[msg.sender]>=amount, "NO you can`t transfer");
        _transfer(msg.sender,recipient,amount);
    }

    function _transfer(address from,address to , uint Amount) private {
        Balance[from]-=Amount;
        Balance[to]+=Amount;
    }
}*/
