import React, { Component } from 'react';

class BooleanField extends Component {
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
        const trueAdj = this.props.trueAdj //if you wanted to pass a custom meaning for true/false
        const falseAdj = this.props.falseAdj
        return <tr>
            <td className="textbox">
                <div className="form-input-select">
                    <select required onChange={(e) => this.validateChange(e)}>
                        <option value=""
                                hidden
                        >{field}</option>

                        <option value="true">{trueAdj ? trueAdj : "Enabled"}</option>
                        <option value="false">{falseAdj ? falseAdj : "Disabled"}</option>
                    </select>
                </div></td>
            <td><span className="reason">{reason}</span></td>
        </tr>
    }
}
export default BooleanField