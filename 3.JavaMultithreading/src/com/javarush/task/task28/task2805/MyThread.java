package com.javarush.task.task28.task2805;

import java.util.Random;

/**
 * Created by MadHarry on 30.07.2017.
 */
public class MyThread extends Thread {
    {   //int i = ;
        while(isAlive()){
        setPriority(new Random(10).nextInt());
        }
    }
    /**
     * If this thread was constructed using a separate
     * <code>Runnable</code> run object, then that
     * <code>Runnable</code> object's <code>run</code> method is called;
     * otherwise, this method does nothing and returns.
     * <p>
     * Subclasses of <code>Thread</code> should override this method.
     *
     * @see #start()
     * @see #stop()
     * @see #Thread(ThreadGroup, Runnable, String)
     */


    /**
     * Allocates a new {@code Thread} object. This constructor has the same
     * effect as {@linkplain #Thread(ThreadGroup, Runnable, String) Thread}
     * {@code (null, null, gname)}, where {@code gname} is a newly generated
     * name. Automatically generated names are of the form
     * {@code "Thread-"+}<i>n</i>, where <i>n</i> is an integer.
     */
    public MyThread() {


    }

    /**
     * Allocates a new {@code Thread} object. This constructor has the same
     * effect as {@linkplain #Thread(ThreadGroup, Runnable, String) Thread}
     * {@code (null, target, gname)}, where {@code gname} is a newly generated
     * name. Automatically generated names are of the form
     * {@code "Thread-"+}<i>n</i>, where <i>n</i> is an integer.
     *
     * @param target the object whose {@code run} method is invoked when this thread
     *               is started. If {@code null}, this classes {@code run} method does
     *               nothing.
     */
    public MyThread(Runnable target) {
        super(target);
    }

    /**
     * Allocates a new {@code Thread} object. This constructor has the same
     * effect as {@linkplain #Thread(ThreadGroup, Runnable, String) Thread}
     * {@code (group, target, gname)} ,where {@code gname} is a newly generated
     * name. Automatically generated names are of the form
     * {@code "Thread-"+}<i>n</i>, where <i>n</i> is an integer.
     *
     * @param group  the thread group. If {@code null} and there is a security
     *               manager, the group is determined by {@linkplain
     *               SecurityManager#getThreadGroup SecurityManager.getThreadGroup()}.
     *               If there is not a security manager or {@code
     *               SecurityManager.getThreadGroup()} returns {@code null}, the group
     *               is set to the current thread's thread group.
     * @param target the object whose {@code run} method is invoked when this thread
     *               is started. If {@code null}, this thread's run method is invoked.
     * @throws SecurityException if the current thread cannot create a thread in the specified
     *                           thread group
     */
    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
    }

    /**
     * Allocates a new {@code Thread} object. This constructor has the same
     * effect as {@linkplain #Thread(ThreadGroup, Runnable, String) Thread}
     * {@code (null, null, name)}.
     *
     * @param name the name of the new thread
     */
    public MyThread(String name) {
        super(name);
    }

    /**
     * Allocates a new {@code Thread} object. This constructor has the same
     * effect as {@linkplain #Thread(ThreadGroup, Runnable, String) Thread}
     * {@code (group, null, name)}.
     *
     * @param group the thread group. If {@code null} and there is a security
     *              manager, the group is determined by {@linkplain
     *              SecurityManager#getThreadGroup SecurityManager.getThreadGroup()}.
     *              If there is not a security manager or {@code
     *              SecurityManager.getThreadGroup()} returns {@code null}, the group
     *              is set to the current thread's thread group.
     * @param name  the name of the new thread
     * @throws SecurityException if the current thread cannot create a thread in the specified
     *                           thread group
     */
    public MyThread(ThreadGroup group, String name) {
        super(group, name);
    }

    /**
     * Allocates a new {@code Thread} object. This constructor has the same
     * effect as {@linkplain #Thread(ThreadGroup, Runnable, String) Thread}
     * {@code (null, target, name)}.
     *
     * @param target the object whose {@code run} method is invoked when this thread
     *               is started. If {@code null}, this thread's run method is invoked.
     * @param name
     */
    public MyThread(Runnable target, String name) {
        super(target, name);
    }

    /**
     * Allocates a new {@code Thread} object so that it has {@code target}
     * as its run object, has the specified {@code name} as its name,
     * and belongs to the thread group referred to by {@code group}.
     * <p>
     * <p>If there is a security manager, its
     * {@link SecurityManager#checkAccess(ThreadGroup) checkAccess}
     * method is invoked with the ThreadGroup as its argument.
     * <p>
     * <p>In addition, its {@code checkPermission} method is invoked with
     * the {@code RuntimePermission("enableContextClassLoaderOverride")}
     * permission when invoked directly or indirectly by the constructor
     * of a subclass which overrides the {@code getContextClassLoader}
     * or {@code setContextClassLoader} methods.
     * <p>
     * <p>The priority of the newly created thread is set equal to the
     * priority of the thread creating it, that is, the currently running
     * thread. The method {@linkplain #setPriority setPriority} may be
     * used to change the priority to a new value.
     * <p>
     * <p>The newly created thread is initially marked as being a daemon
     * thread if and only if the thread creating it is currently marked
     * as a daemon thread. The method {@linkplain #setDaemon setDaemon}
     * may be used to change whether or not a thread is a daemon.
     *
     * @param group  the thread group. If {@code null} and there is a security
     *               manager, the group is determined by {@linkplain
     *               SecurityManager#getThreadGroup SecurityManager.getThreadGroup()}.
     *               If there is not a security manager or {@code
     *               SecurityManager.getThreadGroup()} returns {@code null}, the group
     *               is set to the current thread's thread group.
     * @param target the object whose {@code run} method is invoked when this thread
     *               is started. If {@code null}, this thread's run method is invoked.
     * @param name   the name of the new thread
     * @throws SecurityException if the current thread cannot create a thread in the specified
     *                           thread group or cannot override the context class loader methods.
     */
    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
    }

    /**
     * Allocates a new {@code Thread} object so that it has {@code target}
     * as its run object, has the specified {@code name} as its name,
     * and belongs to the thread group referred to by {@code group}, and has
     * the specified <i>stack size</i>.
     * <p>
     * <p>This constructor is identical to {@link
     * #Thread(ThreadGroup, Runnable, String)} with the exception of the fact
     * that it allows the thread stack size to be specified.  The stack size
     * is the approximate number of bytes of address space that the virtual
     * machine is to allocate for this thread's stack.  <b>The effect of the
     * {@code stackSize} parameter, if any, is highly platform dependent.</b>
     * <p>
     * <p>On some platforms, specifying a higher value for the
     * {@code stackSize} parameter may allow a thread to achieve greater
     * recursion depth before throwing a {@link StackOverflowError}.
     * Similarly, specifying a lower value may allow a greater number of
     * threads to exist concurrently without throwing an {@link
     * OutOfMemoryError} (or other internal error).  The details of
     * the relationship between the value of the <tt>stackSize</tt> parameter
     * and the maximum recursion depth and concurrency level are
     * platform-dependent.  <b>On some platforms, the value of the
     * {@code stackSize} parameter may have no effect whatsoever.</b>
     * <p>
     * <p>The virtual machine is free to treat the {@code stackSize}
     * parameter as a suggestion.  If the specified value is unreasonably low
     * for the platform, the virtual machine may instead use some
     * platform-specific minimum value; if the specified value is unreasonably
     * high, the virtual machine may instead use some platform-specific
     * maximum.  Likewise, the virtual machine is free to round the specified
     * value up or down as it sees fit (or to ignore it completely).
     * <p>
     * <p>Specifying a value of zero for the {@code stackSize} parameter will
     * cause this constructor to behave exactly like the
     * {@code Thread(ThreadGroup, Runnable, String)} constructor.
     * <p>
     * <p><i>Due to the platform-dependent nature of the behavior of this
     * constructor, extreme care should be exercised in its use.
     * The thread stack size necessary to perform a given computation will
     * likely vary from one JRE implementation to another.  In light of this
     * variation, careful tuning of the stack size parameter may be required,
     * and the tuning may need to be repeated for each JRE implementation on
     * which an application is to run.</i>
     * <p>
     * <p>Implementation note: Java platform implementers are encouraged to
     * document their implementation's behavior with respect to the
     * {@code stackSize} parameter.
     *
     * @param group     the thread group. If {@code null} and there is a security
     *                  manager, the group is determined by {@linkplain
     *                  SecurityManager#getThreadGroup SecurityManager.getThreadGroup()}.
     *                  If there is not a security manager or {@code
     *                  SecurityManager.getThreadGroup()} returns {@code null}, the group
     *                  is set to the current thread's thread group.
     * @param target    the object whose {@code run} method is invoked when this thread
     *                  is started. If {@code null}, this thread's run method is invoked.
     * @param name      the name of the new thread
     * @param stackSize the desired stack size for the new thread, or zero to indicate
     *                  that this parameter is to be ignored.
     * @throws SecurityException if the current thread cannot create a thread in the specified
     *                           thread group
     * @since 1.4
     */
    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
    }
}
