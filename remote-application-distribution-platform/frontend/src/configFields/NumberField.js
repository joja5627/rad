import React, { Component } from 'react';

class NumberField extends Component {
    constructor(props) {
        super(props)
        this.state = {
            value: 0
        }
    }

    validateChange = (e) =>{
        e.preventDefault();
        const value = e.target.value
        if(!isNaN(value)){
            if(!this.props.maxLength || (this.props.maxLength && (value / Math.pow(10,this.props.maxLength)) < 1)) {
                this.setState({value})
                this.props.updateValue(this.props.name, value)
            }
        }
    }

    render(){
        const field = this.props.name
        const reason = this.props.reason
        return <tr>
            <td className="textbox">
                <input id={field} className="form-field" placeholder={field} value={this.state.value}
                       onChange={(e) => this.validateChange(e)
                }/>
                <label htmlFor={field} className="form-label">{field}</label></td>
            <td><span className="reason">{reason}</span></td>
        </tr>
    }
}
export default NumberField