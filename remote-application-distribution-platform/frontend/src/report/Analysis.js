import React, { Component } from 'react';
import './analysis.css'
import {Categories} from '../utils/constants'
import {Category} from './Category'

export class Analysis extends Component{

    categorizeTests = (tests) => {
        let categories = []
        for(let c in Categories){
            const data = tests.filter((test) => {
                return test.category === Categories[c]
            })
            console.log(data)
            categories.push(<Category key={Categories[c]} name={Categories[c]} tests={data} expandAll={this.props.expandAll}/>)
        }
        console.log(categories)
        return categories
    }

    render(){
        return (
            <div className="analysis">
                <header className="analysisHeader">
                    <h2>Analysis</h2>
                </header>
                <ul className="categories">
                {
                    this.categorizeTests(this.props.tests)}
                </ul>
            </div>
        )
    }
}