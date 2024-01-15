using System;

namespace EjemploEventosDelegados.Publishers
{

    internal class EventSenderWithArgs : BasicEventSender
    {
        private class MyEventArgs : EventArgs
        {
            public string Message { get; set; }

            public override string ToString()
            {
                return $"Name: {Message}.";
            }
        }

        public void SendEvent(int time, string message)
        {
            System.Threading.Thread.Sleep(time);
            OnEvent(new MyEventArgs()
            {
                Message = message
            });
        }
    }
}
