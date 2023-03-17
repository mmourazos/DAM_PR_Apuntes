using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WPFMVVMBasica.Model
{ 
    internal class Libro
    {
        public string Texto { get; set; }

        public void PasaAMayusculas() 
        {
            Texto = Texto.ToUpper();
        }
       
        public Libro(string texto)
        {
            Texto = texto;
        }
    }
}
