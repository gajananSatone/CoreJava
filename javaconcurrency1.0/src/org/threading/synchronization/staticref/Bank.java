package org.threading.synchronization.staticref;

public class Bank implements Runnable{
	private Account account;

	public Bank(Account account) {
		this.account=account;
	}
	
	@Override
	public void run() {
		for (int i=0; i<100; i++){
			account.subtractAmount(1000);
		}
//		System.out.printf("Bank subtracted %f Balance\n",account.getBalance());
	}
}
