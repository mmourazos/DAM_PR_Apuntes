using EjemploEventosDelegados.Publishers;
using System;

namespace EjemploEventosDelegados.Publisher
{
    internal class EventSender : BasicEventSender
    {
        // Creamos un método que envíe un evento en unos segundos.
        public void SendEvent(int seconds)
        {
            System.Threading.Thread.Sleep(seconds * 1000);
            OnEvent(EventArgs.Empty);
        }
    }
}
