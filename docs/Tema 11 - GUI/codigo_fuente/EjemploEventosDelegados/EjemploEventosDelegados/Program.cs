namespace EjemploEventosDelegados
{
    delegate void TestDlg(int x);

    internal class Program
    {
        static event TestDlg miEvento;
        static void Main(string[] args)
        {

            // Creamos el _publisher_ y el _subscriber_:
            EventSender eventSender = new EventSender();
            BasicEventReceiver eventReceiver = new BasicEventReceiver();

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
