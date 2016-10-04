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
  
  constructor(props) {
      super(props);
		
      this.state = {
         data: 'http://localhost:8081/ChickenReact/depositosJson'
      }

   
  }

		
	
  render() {
	  
	  
    return (
	<div>
      <h1>Home Page Content</h1>
	  {this.props.data}
	
	<table id="tablita">
				<thead>
					<tr>
						<th>nombre</th>
						<th>stock</th>
						<th>stockMax</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
			
	<a href="http://localhost:8081/ChickenReact/depositosJson">Link</a>
</div>
	)
  }
}



export class About extends React.Component {
  render() {
	  var data = "http://localhost:8081/ChickenReact/depositosJson";
    return  (
	<div>
	{this.props.data}
	</div>
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