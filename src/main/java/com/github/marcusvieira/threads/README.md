### Concurrency X Parallelism

Concurrency – More than one task in a single processor.
Parallelism – Many tasks in more than one processor.

#### Synchronization
	Control synchornization – One task depends the end of another task.
	Data access synchronization – Two tasks access a shered data.

#### Critical section
    Piece of code that must be access for only one task per time.

#### Mutual Exclusion
	Granularity
		coarse-grained granularity – big tasks with low intercomunication(low overhead in the synchronization).
		fine-grained granularity – small tasks with high communication(high overhead in the synchronization).
	Synchronization Mechanisms
		Semaphore – control the access to one or more units of a resources, it has a variable that store the number of resources that can be used and two atomic variables to 			manage the value of the variable(a mutex that store only two values, resource is free 		or busy), only the task that sets the resource to busy can released it.
		Monitor – Get a mutal exclusion over a shared resource, it has a mutex(conditional variable) and two operations for wait the condition and signal the condition. Once 		you signal the condition, only one task that is waiting for the condition can go to 			execution.

#### Immutable Object
    Value never change

#### Atomic operations and variables
    Data that is updated instantaneously to the rest of the tasks.

#### Tasks Communication
    Shared memory – when the tasks are running in the same computer.
    message passing – when the tasks are running in different computers.

#### Problems in the concurrency applications
    Data Race – two tasks changing a data outside of critical section(without use synchronization).
    Deadlock – when a taks wait for a resource and stay blocked forever.
    Livelock – when one task hold a resource and block other task(cycle).
    Resouce starvation – task never gets the resource.
    Priority Inversion – task with low priority holds a resource that is needed for the hiw priority task.

#### Design concurrency algorithms
    Start with a sequencial version of the algorithm
    1 – Analyze the code and find the parts that can be run in parallel
    2 – Design the new algorithm, using:
	    Task decomposition and Data Decomposition
    3 – Implementation
    4 – Testing – check if the tasks and data are running in the correct way.
    5 – Tunning –  the new algorithm need to be more fast than the sequencial version.
	Check the performance with:
		Speedup
		Amdahl’s law
		Gustafson-Barsis’ law

### Java Concurrency API

#### Basic Concurrency Classes:
	Thread – Represents a thread.
	Runnable Interface – Another way to create tasks in java.
	Thread Local – Stores variables locally in the thread.
	Thread Factory – Used to create a customized threads.

#### Synchronization mechanisms
	synchronized keyword: define a critical section(block or entire method).
	Lock interface:
		ReentrantLock – lock associated with a condition.
		ReentrantReadWriteLock – separates the reads and writes operations.
		StampedLock – new feature of java 8 , that includes three modes for controlling 			read \ write access.
	Semaphore class: implements the classical semaphore synchronization.
	CountDownLatch class: class that alows a task to wait for a finalization of multiple 	operations.
	CyclicBarrier class: class that allows the synchronization of multiple threads in a common 	point.
	Phaser class: class that allows you to control the execution divided into phases.

#### Executors
	Executor and ExecutorService interfaces: they include common methods for all executors.
	ThreadPoolExecutor class: this class alow you to get a executor with a pool of threads and 	optionally define a maximum number of parallel tasks.
	ScheduledThreadPoolExecutor: This class allow you to execute a executor after a delay or 	periodically.
	Executors: Class that facilites the executor creation.
	Callable interface: This a alternative to runnable interface and RETURN a value.
	Future interface: it includes methods to obtain and return values of a Callable interface.

#### The Fork and Join framework
	Defines a special executor that solve problems with a divicde and conquer technique.
	ForkJoinPool: This is a class that implements the executor that is going to run the tasks.
	ForkJoinTask: This is a task that can be executed in the ForkJoinPool.
	ForkJoinWorkerThread: this is a thread that is going to execute tasks in the ForkJoinPool 	class.

#### Parallel Streams
	Stream interface: that defines all the operations that you can execute in a stream.
	Optional: object that can contain a non-null value.
	Collectors: inplements a reduction operations.
	Lambda Expressions: used to implements a compact version of methods.

#### Concurrent Data Structures (Blocking and non-blocking data structure)
	ConcurrentLinkedDeque – non-blocking list.
	ConcurrentLinkedQueue – non-blocking queue.
	LinkedBlockingDeque – blocking list.
	LinkedBlockingQueue – blocking queue.
	PriorityBlockingQueue – blocking queue that orders the elements based on the priority.
	ConcurrentSkipListMap – non-blocking navigable map.
	ConcurrentHashMap – non-blocking hash map.
	AtomicBolean, AtomicInteger, AtomicLong, AtomicReference – atomic implementations.
	LongAdder and DoubleAdder

#### Concurrency Design Patterns:
	Singleton and 	Factory are most common.
	Signaling (ReentrantLock or Semaphore or wait and notify methods).
	Rendezvous (generalization of Signaling)
	Mutex (implements a critical section with synchronized keyword, ReentrantLock or 	Semaphore class)
	Multiplex (generalization of Mutex implements with Semaphore class, when you have a 	many copis of the resource and you want to set a number of tasks that can execute).
	Barrier (the tasks can not continue while all the tasks not arrived in the same point, 	implements with CyclicBarrier class).
	Double-Checked locking (Singleton classes that have problem in the initialization)
	Read-Write Lock (implements with ReentrantReadWriteLock).

#### ThreadPool
	Creates the threads , it is implemented with ExecutorService interface.

#### ThreadLocal storage
	Defines how to use global and static variables locally to tasks, implements with ThreadLocal 	class.

#### The Java memory model
	It defines the behavior of volatile, sinchronized and final keyworks.

#### Tips for concurrent algorithm
	Indentify the correct independent taks
	Implement concurrency at the highest possible level
	Take scalability into account
	Use thread safe APIS
	Never assume execution order
	Prefer local thread variables ober static and shared when possible
	Find the more easily parallelizable version of the algorithm
	Using immutable objects when possible
	Avoiding deadlocks by ordering the locks
	Using atomic variable instead of synchronization
	Holding locks for as short time as possible
	Taking precautions using Lazy initialization
	Avoiding the use of blocking operations inside a critical section(don’t execute I\O for 	example)