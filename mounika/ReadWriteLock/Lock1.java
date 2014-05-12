package WaitAndNotify;

public class Lock1 {

	// number of readers

	private int readers;

	// writer is 'true' if a writer holds the lock

	private boolean writer;

	private Object synchronizeObject;

	Lock1()

	{

		readers = 0;

		writer = false;

		synchronizeObject = new Object();

	}

	public void get_read_lock() throws InterruptedException

	{
		System.out.println(Thread.currentThread().getName());
		System.out.println(" read lock acquired");

		while (true)

		{

			synchronized (synchronizeObject)

			{

				if (!writer) // no writer

				{

					// one more reader

					readers++;

					break;

				}

				// wait until a lock is released
				System.out.println("iam in wait state");
				synchronizeObject.wait();
				System.out.println("came out of  read wait state");
			}

		}

		return;

	}

	public void release_read_lock()

	{
		System.out.println(Thread.currentThread().getName());
		System.out.println("  read lock released");

		synchronized (synchronizeObject)

		{

			// one fewer reader

			readers--;

			if (readers == 0)

			{

				System.out.println("notifying read thread");
				synchronizeObject.notifyAll();
				System.out.println("come out of read Notify");

			}

		}

	}

	public void get_write_lock() throws InterruptedException

	{
		System.out.println(Thread.currentThread().getName());
		System.out.println(" write lock acquired");

		while (true) {

			synchronized (synchronizeObject)

			{

				if (!writer && (readers == 0)) // no writer or readers

				{

					// make this thread the writer

					writer = true;

					break;

				}

				// wait until a lock is released
				System.out.println("iam in wait state");
				synchronizeObject.wait();
				System.out.println("came out of  write wait state");
			}

		}

		return;

	}

	void release_write_lock()

	{
		System.out.println(Thread.currentThread().getName());
		System.out.println(" write lock released");
		synchronized (synchronizeObject)

		{

			// now no writer

			writer = false;

			// must notify all waiting threads
			System.out.println("notifying");
			synchronizeObject.notifyAll();
			System.out.println("came out of not notify");
		}

	}

}
