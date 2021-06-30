using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;


namespace ConsoleApplication1
{
    class Program
    {
        static AutoResetEvent detectEvent;
        static AutoResetEvent drillEvent;
        static AutoResetEvent cleanEvent;
        static AutoResetEvent wanderEvent;
        static AutoResetEvent cleanDoneEvent;
        static bool isPrinted = false;
        static bool isWandering = true;

        static void Main(string[] args)
        {
            Thread detectThread = new Thread(detect);
            Thread drillThread = new Thread(drill);
            Thread cleanThread = new Thread(clean);

            wanderEvent = new AutoResetEvent(true);
            detectEvent = new AutoResetEvent(false);
            drillEvent = new AutoResetEvent(false);
            cleanEvent = new AutoResetEvent(false);
            cleanDoneEvent = new AutoResetEvent(true);
            Console.WriteLine("Main thread running,Rover started and running...");

            detectThread.Start();
            drillThread.Start();
            cleanThread.Start();


            while (true)
            {
                Console.WriteLine("Main thread is waiting...");
                wanderEvent.WaitOne();
                Console.WriteLine("Main thread is running...");
                if (isWandering)
                {
                    Console.WriteLine("Rover is wondering...");
                    Thread.Sleep(1000);//to simulate wondering time
                    isWandering = false;

                    detectEvent.Set();
                }
            }
        }



        //detect the material
        static void detect()
        {
            while (true)
            {
                if (!isPrinted)
                {
                    Console.WriteLine("detect thread is waiting...");
                }
                detectEvent.WaitOne();
                if (!isPrinted)
                {
                    Console.WriteLine("Detect thread is running...");
                    Console.WriteLine("Detecting materials...");
                    isPrinted = true;
                }
                Thread.Sleep(100);//to simulate detect time
                Random material = new Random();
                int materialDiscoverd = material.Next(1, 30);
                if (materialDiscoverd == 13)
                {
                    Console.WriteLine("Material is detected");
                    drillEvent.Set();
                }
                else
                {
                    detectEvent.Set();
                }
            }
        }

        //drill the material out
        static void drill()
        {
            while (true)
            {
                Console.WriteLine("Drill thread is waiting...");
                drillEvent.WaitOne();
                Console.WriteLine("Drill thread is running...");
                isPrinted = false;
                Console.WriteLine("Drilling out the detected material...");
                Thread.Sleep(5000);//to simulate the drilling time
                Console.WriteLine("Material is drilled");
                Console.WriteLine("Waiting clean thread to finish...");
                cleanDoneEvent.WaitOne();
                cleanEvent.Set();
                wanderEvent.Set();
                isWandering = true;
            }
        }

        //clean the material
        static void clean()
        {
            while (true)
            {
                Console.WriteLine("Clean thread is waiting...");
                cleanEvent.WaitOne();
                Console.WriteLine("Clean thread is running...");
                Console.WriteLine("Cleaning drilled material...");
                Thread.Sleep(3000);//to simulate cleaning time
                Console.WriteLine("Cleaning done");
                cleanDoneEvent.Set();
            }
        }
    }
}
