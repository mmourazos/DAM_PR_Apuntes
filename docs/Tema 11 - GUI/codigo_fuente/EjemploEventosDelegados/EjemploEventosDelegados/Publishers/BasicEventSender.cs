using System;

namespace EjemploEventosDelegados.Publishers
{
    internal class BasicEventSender
    {
        // 1.- Definir un delegado para el evento.
        // El delegado especificará el "contrato" entre el _publisher_ y el _subscriber_.
        private delegate void EventHandler(object sender, EventArgs e);

        // 2.- Declaramos el evento de tipo EventHandler
        public event EventHandler<EventArgs> Event;

        // 3.- Declaramos un método para _activar_ el evento (y avistar a subscriptores) cuando 
        // suceda _algo_.
        // NOTA: Por **convenio** el método que avisa a subscriptores (= lanza el evento) debe:
        // 1.- Ser declarado protected (lo verán _sólo_ las clases que hereden de ésta.
        // 2.- Ser declarado virtual (para que pueda sobreescribirse con _override_ en las subclases
        //     según sea necesario.
        // 3.- Su nombre debería empezar por "On" seguido del nombre del evento.
        protected virtual void OnEvent(EventArgs e)
        {

            //if (Event != null) // Si hay "alguien" subscrito
            //{
            //    Event(this, e); // Invocamos los métodos de los subscriptores.
            //}

            // Las líneas anteriores de código se pueden reducir utilizando esta sintaxis:
            // NOTA: El código HACE LO MISMO.
            Event?.Invoke(this, e);
        }
    }
}
