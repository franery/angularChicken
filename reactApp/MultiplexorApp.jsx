import React from 'react';

class MultiplexorApp extends React.Component {
   constructor() {
      super();
		
      this.state = {
         data: [""]
      }
	
      this.setStateHandler = this.setStateHandler.bind(this);
      this.setStateDecode = this.setStateDecode.bind(this);
      this.setStateRandom = this.setStateRandom.bind(this);
   };

   setStateHandler() {
	var len = this.state.data.length;
      for(var i = 0; i < len ; i++ ) {
            var item = <button onClick = {this.setStateHandler}>MULTIPLEXOR</button>
            var myArray = this.state.data;
            myArray.push(item);
            this.setState({data: myArray});
	}
   };

   setStateDecode() {
      var len = this.state.data.length;
      var newData = this.state.data.slice(); //copy array
      newData.splice(1, len/2); //remove element
      this.setState({data: newData}); //update state
   }

   setStateRandom() {
         var numero = Math.floor(Math.random() * 2);
         switch(numero) {
            case 0: 
                  this.setStateHandler();
                  break;
            case 1:
                  this.setStateDecode();
                  break;
         }

   }

   render() {
      return (
         <div>
            <button onClick = {this.setStateHandler}>MULTIPLEXOR</button>
            <button onClick = {this.setStateDecode}>DECODIFICADOR</button>
            <button onClick = {this.setStateRandom}>RANDOM</button>
            <h4>State Array: {this.state.data}</h4>
         </div>
      );
   }
}


export default MultiplexorApp;