import React from 'react';
import {Link} from 'react-router';
import MultiplexorApp from './MultiplexorApp.jsx';

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
  render() {
    return (
      <h1>Home Page Content</h1>
    )
  }
}



export class About extends React.Component {
  render() {
    return (
      <h1>ASDASDdasdASD</h1>
    )
  }
}


export class Contact extends React.Component {
  render()  {
    return (
      <h1>Contact Page Content</h1>
    )
  }
}