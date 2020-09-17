using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ClassLibrary
{
    public class PartDestination
    {
        public PartDestination(string partType, string receiverName, string receiverAddress, string receiverCountry)
        {
            this.partType = partType;
            this.receiverName = receiverName;
            this.receiverAddress = receiverAddress;
            this.receiverCountry = receiverCountry;
        }
        
        public string partType { get; set; }
        public string receiverName { get; set; }
        public string receiverAddress { get; set; }
        public string receiverCountry { get; set; }
    }
}
