using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EjemploEventosDelegados.Subscribers
{
    internal class BasicEventReceiver
    {
        protected virtual void OnPropertyChanged(object sender, PropertyChangedEventArgs e)
        {
            throw new NotImplementedException();
        }
        public void OnEventReceived(object sender, EventArgs e)
        {
            Console.WriteLine($"Received event from {sender} with args: {e}.");
        }
    }
}
