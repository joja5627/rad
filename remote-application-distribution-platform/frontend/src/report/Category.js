import React, { Component } from 'react';
import {Test} from './Test'
import './category.css'

export class Category extends Component{
    constructor(props) {
        super(props)

        console.log(this.props.name)
        this.state = {
            expanded: false
        }
    }

    componentDidUpdate(prevProps){
        //expanding all for export
        if(!prevProps.expandAll && this.props.expandAll){
            this.setState({
                expanded: true
            })
        }
    }

    handleClick = (e) => {
        const currentState = this.state.expanded
        this.setState({
            expanded: !currentState
        })
        // let elem = e.target.parentElement.parentElement
        // if(elem && elem.children){
        //     const len = elem.children.length
        //     elem = elem.children[len-1]
        //     if(currentState)
        //         elem.classList.remove("show")
        //     else
        //         elem.classList.add("show")
        // }
    }

    render(){
        const iconString = this.state.expanded ? 'icon fa fa-chevron-circle-up' : 'icon fa fa-chevron-circle-down'
        return (
            <div className="cat" id={this.props.name}>
                <i className={iconString} onClick={this.handleClick}></i><b>{this.props.name}</b>
                <ul className="testList">
                {
                    this.state.expanded ?
                            this.props.tests.map((test) =>{
                                return (<li key={test.number}>
                                    <Test number={test.number} name={test.name} description={test.description} status={test.status}
                                          message={test.message} splitStatus={test.splitStatus} expandAll={this.props.expandAll}/>
                                </li>)
                            })
                            :
                        null
                }
                </ul>
            </div>
        )
    }
}