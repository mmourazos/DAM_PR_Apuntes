using EjemploEventosDelegados.Publisher;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EjemploEventosDelegados.Subscribers
{
    internal class EventReceiver : BasicEventReceiver
    {
        // Debo declarar un método _subscriptor_ con la firma void NombreMetodo(object sender, EventArgs e)
        protected void OnEventReceived(object sender, EventArgs e)
        {
            Console.WriteLine($"Event received from {sender} with arguments {e}.");
        }
    }
}
