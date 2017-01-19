package com.mine.finalize;

public class FinallizeTest {
	
	public static FinallizeTest SAVE_HOOK = null;
	
	public void isAlive() {
		System.out.println("yes, i am alive");
	}
	
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("finalize method executed");
		FinallizeTest.SAVE_HOOK = this;
	}
	
	public static void main(String[] args) throws InterruptedException {
		SAVE_HOOK = new FinallizeTest();
		
		SAVE_HOOK = null;
		System.gc();
		Thread.sleep(1000);
		if (SAVE_HOOK != null) {
			SAVE_HOOK.isAlive();
		} else {
			System.out.println("no, i am dead");
		}
		
		SAVE_HOOK = null;
		System.gc();
		Thread.sleep(1000);
		if (SAVE_HOOK != null) {
			SAVE_HOOK.isAlive();
		} else {
			System.out.println("no, i am dead");
		}
		
	}

}
