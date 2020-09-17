using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ClassLibrary
{
    public class Part
    {
        public string Type { get; set; }
        public string CarVIN { get; set; }
        public double Weight { get; set; }

        public Part(string type, double weight)
        {
            this.Type = type;
            this.CarVIN = null;
            this.Weight = weight;
        }
    }
}
