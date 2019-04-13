import React, { Component } from 'react';

class IPField extends Component {
    constructor(props) {
        super(props)
        this.state = {
            value: "100.100.100.100"
        }
    }

    validateChange = (e) =>{
        e.preventDefault();
        const value = e.target.value
        //ip regex
        if(/^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$/.test(value)){
            this.setState({value})
            this.props.updateValue(this.props.name, value)
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
            <td className="reason">{reason}</td>
        </tr>
    }
}
export default IPField