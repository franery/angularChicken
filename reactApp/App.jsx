import React from 'react';
import fecth from 'isomorphic-fetch';
import promise from 'es6-promise';
import {Link} from 'react-router';
import MultiplexorApp from './MultiplexorApp.jsx';
var ReactCSSTransitionGroup = require('react-addons-css-transition-group');

class App extends React.Component {
  render() {
    return(
      <div>
        <ul>
            <li><Link to="home">Home</Link></li>
            <li><Link to="about">About</Link></li>
            <li><Link to="contact">Contact</Link></li>
            <li><Link to="multiplexor">Multiplexor</Link></li>
        </ul>
      {this.props.children}
      </div>
    )
  }
}
export default App;

export class Home extends React.Component {
  constructor(props) {
      super(props);
		
      this.state = {
         data: 'Initial data...'
      }

      this.updateState = this.updateState.bind(this);

   };

   updateState(e) {
      this.setState({data: e.target.value});
   }

   render() {
      return (
         <div>
            <input type = "text" value = {this.state.data} 
               onChange = {this.updateState} />
            <h4>{this.state.data}</h4>
         </div>
      );
   }
}

export class About extends React.Component {
    constructor() {
        super();
        this.state = { items: [] };

        this.recargar = this.recargar.bind(this);
    }
    
    recargar() {
        var xhr = createCORSRequest('GET', 'http://localhost:8080/ChickenReact/usuariosJson');
        xhr.send();
        xhr.onload = function() {
            var responseText = xhr.responseText;
            responseText = JSON.parse(responseText);
            this.setState({items: responseText.data});
        }.bind(this);
    }

    componentWillMount() {
        this.recargar();
        setInterval(this.recargar,5000);
    }
   
    render() {
        return  (
        <div>
            <ul>
               {this.state.items.map(item=><li key={item.id}>{item.id} {item.nombre} {item.apellido}</li>)}
            </ul>  
        </div>
        )
    }
}

export class Contact extends React.Component {
  constructor(props) {
      super(props);
		
      this.state = {
         items: ['Item 1...', 'Item 2...', 'Item 3...', 'Item 4...']
      }

      this.handleAdd = this.handleAdd.bind(this);
   };

   handleAdd() {
      var newItems = this.state.items.concat([prompt('Create New Item')]);
      this.setState({items: newItems});
   }

   handleRemove(i) {
      var newItems = this.state.items.slice();
      newItems.splice(i, 1);
      this.setState({items: newItems});
   }

   render() {
      var items = this.state.items.map(function(item, i) {
         return (
            <div key = {item} onClick = {this.handleRemove.bind(this, i)}>
               {item}
            </div>
         );
			
      }.bind(this));
		
      return (
         <div>      
            <button onClick = {this.handleAdd}>Add Item</button>
				
            <ReactCSSTransitionGroup transitionName = "example" 
               transitionEnterTimeout = {500} transitionLeaveTimeout = {500}>
               {items}
            </ReactCSSTransitionGroup>
         </div>
      );
   }
}

function createCORSRequest(method, url) {
  var xhr = new XMLHttpRequest();
  if ("withCredentials" in xhr) {

    // Check if the XMLHttpRequest object has a "withCredentials" property.
    // "withCredentials" only exists on XMLHTTPRequest2 objects.
    xhr.open(method, url, true);

  } else if (typeof XDomainRequest != "undefined") {

    // Otherwise, check if XDomainRequest.
    // XDomainRequest only exists in IE, and is IE's way of making CORS requests.
    xhr = new XDomainRequest();
    xhr.open(method, url);

  } else {

    // Otherwise, CORS is not supported by the browser.
    xhr = null;

  }
  return xhr;
}



