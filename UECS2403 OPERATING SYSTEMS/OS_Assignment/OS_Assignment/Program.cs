using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace OS_Assignment
{
    class Program
    {
        static AutoResetEvent ArmTask;
        static AutoResetEvent LegTask;
        static AutoResetEvent BodyTask;
        static AutoResetEvent AssemblerTask;
        static AutoResetEvent IdleTask;
        static AutoResetEvent Packager;
        static AutoResetEvent PackagerDone;

        static bool isPrinted = false;
        static bool isIdling = true;

        static void Main(string[] args)
        {
            Thread ArmThread = new Thread(arm);
            Thread LegThread = new Thread(leg);
            Thread BodyThread = new Thread(body);
            Thread AssemblerThread = new Thread(assembler);
            Thread PackagerThread = new Thread(packager);

            ArmTask = new AutoResetEvent(false);
            LegTask = new AutoResetEvent(false);
            BodyTask = new AutoResetEvent(false);
            IdleTask = new AutoResetEvent(true);
            AssemblerTask = new AutoResetEvent(false);
            Packager = new AutoResetEvent(false);
            PackagerDone = new AutoResetEvent(true);
            Console.WriteLine("Main thread running, Chair Assembly starts...");

            ArmThread.Start();
            LegThread.Start();
            BodyThread.Start();
            AssemblerThread.Start();
            PackagerThread.Start();
            
            while (true)
            {
                Console.WriteLine("Main thread: Waiting...");
                IdleTask.WaitOne();
              
                Console.WriteLine("Main thread: Running...");
                if (isIdling)
                {
                    
                    ArmTask.Set();
                    LegTask.Set();
                    BodyTask.Set();
                    Console.WriteLine("Operation: Waiting...");
                    Thread.Sleep(1000);//to simulate waiting time
                    isIdling = false;
                    AssemblerTask.Set();
             
                }

            }
        }
        
        //crafting the arm
        static void arm()
        {
            while (true)
            {
               Console.WriteLine("ArmTask: Waiting...");
               ArmTask.WaitOne();
               Console.WriteLine("ArmTask: Running...");
               isPrinted = false;
               Console.WriteLine("ArmTask: Crafting...");
               Thread.Sleep(100);//to simulate crafting time
               Console.WriteLine("ArmTask: Completed");
               isIdling = true;

            }
        }

        //crafting the leg 
        static void leg()
        {
            while (true)
            {
               
               Console.WriteLine("LegTask: Waiting...");
               LegTask.WaitOne();
               Console.WriteLine("LegTask: Running...");
               isPrinted = false;
               Console.WriteLine("LegTask: Crafting...");
               Thread.Sleep(100);//to simulate crafting time
               Console.WriteLine("LegTask: Completed");
               isIdling = true;

            }
        }

        //crafting the body
        static void body()
        {
            while (true)
            {

                Console.WriteLine("BodyTask: Waiting...");
                BodyTask.WaitOne();
                Console.WriteLine("BodyTask: Running...");
                isPrinted = false;
                Console.WriteLine("BodyTask: Crafting...");
                Thread.Sleep(100);//to simulate crafting time
                Console.WriteLine("BodyTask: Completed");
                isIdling = true;
            }
        }

        //assemble the chair
        static void assembler()
        {
            while (true)
            {
                if (!isPrinted)
                {
                    Console.WriteLine("AssemblerTask: Waiting...");
                }
                AssemblerTask.WaitOne();
                if (!isPrinted)
                {
                    Console.WriteLine("AssemblerTask: Running...");
                    Console.WriteLine("AssemblerTask: Assembling...");
                    isPrinted = true;
                }

                Thread.Sleep(100);//to simulate the assembling time
                Random crafted = new Random();
                int chairCrafted = crafted.Next(1, 30);
                if (chairCrafted == 6)
                {
                    Console.WriteLine("AssemblerTask: Completed");
                    PackagerDone.WaitOne();
                    Packager.Set();
                }
                else
                {
                   
                    AssemblerTask.Set();
                }
            }
        }

        //package the chair
        static void packager()
        {
            while (true)
            {
                Console.WriteLine("Packager: Waiting...");
                Packager.WaitOne();
                Console.WriteLine("Packager: Running...");
                Console.WriteLine("Packager: Packaging....");
                Thread.Sleep(1000);//to simulate packaging time
                Console.WriteLine("Packager: Completed");
                PackagerDone.Set();
                //IdleTask.Set();
                //isIdling = true;
            }
        }
    }
}
