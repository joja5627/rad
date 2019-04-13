import React, { Component } from 'react';
import './resultQuickview.css'
import repair from '../images/repair.svg'
import {Status} from '../utils/constants'

export class ResultQuickview extends Component{
    handleClickedButton = (page) => {
        this.props.changePage(page)
    }

    returnSoloButton = (page) => {
        console.log(page)
        switch(page){
            case Status.FAIL:
                return (<span className="soloButton fail">
                    <div className="count"><span className="statusIcon"><i className="fa fa-times-circle fa-lg"></i></span><span>{this.props.values[Status.FAIL]}</span></div>
                    <span className="status">Failed</span>
                </span>)
            case Status.PASS:
                return(<span className="soloButton pass">
                    <div className="count"><span className="statusIcon"><i className="fa fa-check-circle fa-lg"></i></span><span>{this.props.values[Status.PASS]}</span>
                    </div>
                    <span className="status">Passed</span>
                </span>)
            case Status.RESOLVED:
                return(<span className="soloButton resolved">
                        <div className="count"><span className="statusIcon"><img src={repair} alt="resolved"/></span><span>{this.props.values[Status.RESOLVED]}</span></div>
                    <span className="status">Resolved</span>
                </span>
                )
            case Status.WORKAROUND:
                return(<span className="soloButton workaround">
                        <div className="count"><span className="statusIcon"><i className="fa fa-exclamation-triangle fa-lg"></i></span><span>{this.props.values[Status.WORKAROUND]}</span></div>
                    <span className="status">Workaround</span>
                </span>
                )
            default:
                return null
        }
    }

    render(){
        return (this.props.page === null ?
            <div style={{width: '100%'}}>
                <span className="button pass" onClick={() => this.handleClickedButton(Status.PASS)}>
                    <div className="count"><span className="statusIcon"><i className="fa fa-check-circle fa-lg"></i></span><span>{this.props.values[Status.PASS]}</span>
                    </div>
                    <span className="status">Passed</span>
                </span>
                <span className="button fail" onClick={() => this.handleClickedButton(Status.FAIL)}>
                    <div className="count"><span className="statusIcon"><i className="fa fa-times-circle fa-lg"></i></span><span>{this.props.values[Status.FAIL]}</span></div>
                    <span className="status">Failed</span>
                </span>
                <span className="button resolved" onClick={() => this.handleClickedButton(Status.RESOLVED)}>
                    <div className="count"><span className="statusIcon"><img src={repair} alt="resolved"/></span><span>{this.props.values[Status.RESOLVED]}</span></div>
                    <span className="status">Resolved</span>
                </span>
                <span className="button workaround" onClick={() => this.handleClickedButton(Status.WORKAROUND)}>
                    <div className="count"><span className="statusIcon"><i className="fa fa-exclamation-triangle fa-lg"></i></span><span>{this.props.values[Status.WORKAROUND]}</span></div>
                    <span className="status">Workaround</span>
                </span>
            </div>
                :
            <div style={{width: '100%'}}>
                <span className="backbutton" onClick={() => this.handleClickedButton(null)}>
                    <i className="fa fa-arrow-circle-o-left"></i><b><i>Full Report</i></b></span>
                {this.returnSoloButton(this.props.page)}
            </div>
        )
    }
}