import React, { Component } from 'react';

class ClassificationField extends Component {
    constructor(props) {
        super(props)
    }

    validateChange = (e) =>{
        e.preventDefault()
        //theres no way for this to be invalid since its a fixed list
        this.props.updateValue(this.props.name, e.target.value)
    }

    render(){
        const field = this.props.name
        const reason = this.props.reason
        return <tr>
            <td className="textbox">
                <div className="form-input-select">
                    <select required onChange={(e) => this.validateChange(e)}>
                        <option value=""
                                hidden
                        >{field}</option>

                        <option value="UNCLASSIFIED">Unclassified</option>
                        <option value="RESTRICTED">Restricted</option>
                        <option value="CONFIDENTIAL">Confidential</option>
                        <option value="SECRET">Secret</option>
                        <option value="TOP SECRET">Top Secret</option>
                    </select>
                </div></td>
            <td className="reason">{reason}</td>
        </tr>
    }
}
export default ClassificationField