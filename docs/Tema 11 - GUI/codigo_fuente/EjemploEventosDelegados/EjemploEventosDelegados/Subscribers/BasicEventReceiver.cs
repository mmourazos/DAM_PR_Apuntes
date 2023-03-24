using System;
using System.ComponentModel;

namespace EjemploEventosDelegados.Subscribers
{
    internal class BasicEventReceiver
    {
        protected virtual void OnPropertyChanged(object sender, PropertyChangedEventArgs e)
        {
            throw new NotImplementedException();
        }
    }
}
