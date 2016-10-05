import React from 'react';

class MultiplexorApp extends React.Component {
   constructor() {
      super();
		
      this.state = {
         data: [""]
      }
	
      this.setStateHandler = this.setStateHandler.bind(this);
   };

   setStateHandler() {
	var len = this.state.data.length;
   for(var i = 0; i < len ; i++ ) {
      
	 var item = <button onClick = {this.setStateHandler}>MULTIPLEXOR</button>
      var myArray = this.state.data;
      myArray.push(item)
      myArray.push(item)
      this.setState({data: myArray})
	}
   };

   render() {
      return (
         <div>
            <button onClick = {this.setStateHandler}>MULTIPLEXOR</button>
            <h4>State Array: {this.state.data}</h4>
         </div>
      );
   }
}


export default MultiplexorApp;