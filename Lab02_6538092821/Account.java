public class Account {
    private String accountId;
    private String accountName;
    private TransactionManager transactionManager;
    private double balance;

    public Account(String accountId, String accountName) {
    	// Put your code here
    	this.accountId = accountId;
    	this.accountName = accountName;
    	transactionManager =  TransactionManager.getInstance();	
    	
    	
    	
    }

    public void deposit(double amount) throws NegativeAmountException {
    	// Put your code here
    	testPositiveAmount(amount);
    	balance += amount;
    	String str = String.format("DEPOSIT - Amount: %s - Account ID: %s", amount, accountId);
    	transactionManager.logTransaction(str);
    	
    	
    	
    	
    	
    }

    public void withdraw(double amount) throws NegativeAmountException, InsufficientAmountException {
    	// Put your code here
    	testPositiveAmount(amount);
    	testInsufficientAmount(balance, amount);
    	balance -= amount;
    	String str = String.format("WITHDRAW - Amount: %s - Account ID: %s", amount, accountId);
    	transactionManager.logTransaction(str);
    	
    	
    	
    	
    	

    
    
    
    
    }

    public void transfer(Account targetAccount, double amount) throws NegativeAmountException, InsufficientAmountException {
    	// Put your code here
    	testPositiveAmount(amount);
    	testInsufficientAmount(balance, amount);
    	balance -= amount;
    	targetAccount.addBalance(amount);
    	String str = String.format("TRANSFER - Amount: %s - From Account ID: %s - To Account ID: %s", amount, this.accountId, targetAccount.getAccountId());
    	transactionManager.logTransaction(str);
    	
  
    
    
    }
    
    private void testPositiveAmount(double amount) throws NegativeAmountException {
    	if(amount<0) throw new NegativeAmountException("the amount cannot be negative");
    }
    private void testInsufficientAmount(double balance, double amount) throws InsufficientAmountException {
    	if(amount>balance) throw new InsufficientAmountException("the balance is not sufficient");
    }

    private void addBalance(double amount) {
    	this.balance += amount;
    }
    public double getBalance() {
        return balance;
    }
    
    public String getAccountId() {
    	return accountId;
    }

}