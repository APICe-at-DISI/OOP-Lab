package it.unibo.oop.lab03.interfaces;

public interface BankAccount {
    void withdraw(int usrID, double amount);

    void deposit(int usrID, double amount);

    void depositFromATM(int usrID, double amount);

    void withdrawFromATM(int usrID, double amount);

    void computeManagementFees(int usrID);

    double getBalance();

    int getNTransactions();
}