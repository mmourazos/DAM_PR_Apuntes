using System;

namespace EjemploEventosDelegados.Subscribers
{
    internal class EventReceiver : BasicEventReceiver
    {
        // Debo declarar un método _subscriptor_ con la firma void NombreMetodo(object sender, EventArgs e)
        public void OnEventReceived(object sender, EventArgs e)
        {
            Console.WriteLine($"Event received from {sender} with arguments {e}.");
        }
    }
}
