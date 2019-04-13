import React, { Component } from 'react';
import './tests.css'

export class Test extends Component{
    constructor(props) {
        super(props)

        if(this.props.expandAll){
            this.state = {
                expanded: true
            }
        }
        else {
            this.state = {
                expanded: false
            }
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
    }

    returnAdvacedStatusInfo = (status) => {
        const entities = Object.keys(status)
        let table = <table className="statusTable">
            <tbody>
            <tr>
                {entities.map((e) => {
                    return <th key={e}>{e}</th>
                })}
            </tr>
            <tr>
                {entities.map((e) => {
                    return <td key={e} className={"tableEntry " + status[e].status}>{status[e].status}</td>
                })}
            </tr>
            </tbody>
        </table>
        return table
    }

    render(){
        const iconString = this.state.expanded ? 'icon fa fa-chevron-circle-up' : 'icon fa fa-chevron-circle-down'
        let statusString = 'testStatus ' + this.props.status
        return (
            <div className="test">
                <span className="testNum">
                    {/*<span className={"circle " + this.props.status}></span>*/}
                    <i className={iconString} onClick={this.handleClick}></i><b>Test {this.props.number}:</b>
                    <span className={"circle " + this.props.status}></span>
                </span>
                {this.props.name} <span className={statusString}><b> {this.props.status} </b></span>
                {this.state.expanded ? <div className="moreInfo">
                    DETAILED TEST INFORMATION: {this.props.description + '. '}
                    <p>{this.props.message}</p>
                    {this.props.splitStatus !== null && this.props.splitStatus !== undefined ?
                       this.returnAdvacedStatusInfo(this.props.splitStatus) : null}
                </div> : null}
            </div>
        )
    }
}