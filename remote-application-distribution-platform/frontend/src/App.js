import React, { Component } from "react";
import Report from "./report/report";
import * as HttpUtils from "./utils/HttpUtils";
import "./App.css";
import { HttpConstants, Endpoints } from "./utils/constants";
import NumberField from "./configFields/NumberField";
import IPField from "./configFields/IPField";
import ClassificationField from "./configFields/ClassificationField";
import BooleanField from "./configFields/BooleanField";

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      server: "APP Server",
      config: {},
      testsDone: false,
      testsInitiated: false,
      testData: null,
      invalidFormMsg: ""
    };
  }

  getConfigFields() {
    let url =
      HttpConstants.LOCALHOST + window.location.port + Endpoints.GET_CONFIG;

    HttpUtils.get(url)
      .then(response => response.json())
      .then(config => {
        if (config) {
          this.setState({
            config: config.userConfigFields,
            server: config.serverType
          });
        }
      })
      .catch(error => console.log(error));
  }

  componentDidMount() {
    this.getConfigFields();
  }

  componentDidUpdate() {}

  exit = async e => {
    e.preventDefault();

    let url = HttpConstants.LOCALHOST + window.location.port + Endpoints.EXIT;

    HttpUtils.post(url, {})
      .then(response => response.json)
      .then(results => {})
      .catch(error => console.log(error));

    window.close();
  };

  runTests = async e => {
    e.preventDefault();

    // verify fields
//    let msg = "";
//    Object.keys(this.state.config).map(key => {
//      if (key && this.state.config[key]) {
//        if (!this.state.config[key].value) {
//          msg += "The " + key + " field is required\n";
//        }
//      }
//    });
//    if (msg != "") {
//      this.setState({ invalidFormMsg: msg });
//      return;
//    }

    this.setState({ testsInitiated: true });


    let url =
      HttpConstants.LOCALHOST + window.location.port + Endpoints.INITIATE_TESTS;

    HttpUtils.post(url, this.state.config)
      .then(response => response.json())
      .then(results => {
        this.setState({
          testsDone: true,
          testData: results,
          testsInitiated: false
        });
      })
      .catch(error => console.log(error));
  };

  updateValue = (name, value) => {
    this.setState({
      config: {
        ...this.state.config,
        [name]: { ...this.state.config[name], value: value }
      }
    });
  };

  render() {
    const config = this.state.config;
    if (!this.state.testsDone)
      return (
        <div className="config">
          <header>
            <h1>Local Configuration</h1>
            <span className="exit" onClick={this.exit}>
              Exit
            </span>
            <span className="runTests" onClick={this.runTests}>
              Run Tests
            </span>
          </header>
          <div className="server">
            <b>{this.state.server}</b>
        </div>
        <ul style={{listStyleType: "none", color: "red"}}>
            {this.state.invalidFormMsg ? this.state.invalidFormMsg.split("\n").map((msg)=>{
                return <li>{msg}</li>
            }) : null
            }
        </ul>
        <table className="entries">
          <tbody>
            {Object.keys(config).map((key) => {
                if(key && config[key])
                    switch(config[key].fieldType.toLowerCase()){
                        case "classification":
                            return <ClassificationField name={key} reason={config[key].description} updateValue={this.updateValue}/>
                        case "boolean":
                            return <BooleanField name={key} reason={config[key].description} updateValue={this.updateValue}/>
                        case "ip":
                            return <IPField name={key} reason={config[key].description} updateValue={this.updateValue}/>
                        case "port":
                            return <NumberField name={key} reason={config[key].description} maxLength={5} updateValue={this.updateValue}/>
                        case "number":
                            return <NumberField name={key} reason={config[key].description} updateValue={this.updateValue}/>
                        default:
                            return <tr key={key}>
                                        <td className="textbox">
                                            <input id={key} className="form-field" placeholder={key}
                                                   onChange={(e) => this.updateValue(key, e.target.value)}/>
                                            <label htmlFor={key} className="form-label">{key}</label></td>
                                        <td><span className="reason">{config[key].description}</span></td>
                                    </tr>
                    }
              })}
            </tbody>
          </table>
          {this.state.testsInitiated ? (
            <span>
              <p>
                <b>
                  <i>Running Tests</i>
                </b>
              </p>
              <div className="lds-ring">
                <div />
                <div />
                <div />
                <div />
              </div>
            </span>
          ) : null}
        </div>
      );
    else return <Report data={this.state.testData} />;
  }
}

export default App;
