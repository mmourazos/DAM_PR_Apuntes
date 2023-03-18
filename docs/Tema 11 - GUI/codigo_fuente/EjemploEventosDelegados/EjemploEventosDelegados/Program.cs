using EjemploEventosDelegados.Publisher;
using EjemploEventosDelegados.Subscribers;

namespace EjemploEventosDelegados
{
    internal class Program
    {
        static void Main(string[] args)
        {
            // Creamos el _publisher_ y el _subscriber_:
            EventSender eventSender = new EventSender();
            BasicEventReceiver eventReceiver = new BasicEventReceiver();

            // Nos subscribimos al sender:
            eventSender.Event += eventReceiver.OnEventReceived;

            eventSender.SendEvent(3);
        }
    }
}
