using EjemploEventosDelegados.Publisher;
using EjemploEventosDelegados.Subscribers;

namespace EjemploEventosDelegados
{


    internal class Program
    {
        // Declaramos un **tipo** delegado `TextDlg`.
        internal delegate void TestDlg(int x);



        static void MetodoADelegar1(int x)
        {
            System.Console.WriteLine($"MetodoADelegar1: {x}.");
        }
        static void MetodoADelegar2(int x)
        {
            System.Console.WriteLine($"MetodoADelegar2: {x}.");
        }

        static void Main(string[] args)
        {

            // Creamos el _publisher_ y el _subscriber_:
            EventSender eventSender = new EventSender();
            EventReceiver eventReceiver = new EventReceiver();

            // Nos subscribimos al sender:
            eventSender.Event += eventReceiver.OnEventReceived;

            eventSender.SendEvent(3);

            // --- OTROS TESTS ---
            //TestDlg testDlg = null;

            //testDlg = new TestDlg(x => { Console.WriteLine(x); });
            //testDlg += x => { Console.WriteLine(x); };


            //miEvento(5);
        }
    }
}
