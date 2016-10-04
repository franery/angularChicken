import React from 'react';
import fecth from 'isomorphic-fetch';
import promise from 'es6-promise';

export default class ItemLister extends React.Component {
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
        return(
            <ul>
				{this.state.items.map(item=><li key={item.id}>{item.nombre} {item.id}</li>)}
			</ul>  
        );
    }
}