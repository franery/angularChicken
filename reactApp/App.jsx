import React from 'react';
import fecth from 'isomorphic-fetch';
import promise from 'es6-promise';
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



  var CommentBox = React.createClass({
  loadCommentsFromServer: function() {
    $.ajax({
      url: this.props.url,
      dataType: 'json',
      cache: false,
      success: function(data) {
        this.setState({data: data});
      }.bind(this),
      error: function(xhr, status, err) {
        console.error(this.props.url, status, err.toString());
      }.bind(this)
    });
  },
  render(){
	  return (
	   <div className="commentBox">
        <h1>Comments</h1>
        {this.state.data} 
		</div>
	  )
  }
});


export class Home extends React.Component {
  
	
  render() {
	  
    return (


	<div>



	<h1>Home Page Content</h1>
	
	
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
		

</div>
	)
  }
} 


export class About extends React.Component {

    constructor() {
        super();
        this.state = { items: [] };
    }
    
    componentDidMount() {
        fetch('http://localhost:8080/ChickenReact/usuariosJson') 
            .then(result=>result.json())
				.then(items=>this.setState({items: items.data}))
    }
    
  render() {
	 
    return  (
	<div>


            <ul>
				{this.state.items.map(item=><li key={item.id}>{item.nombre} {item.id}</li>)}
			</ul>  

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

