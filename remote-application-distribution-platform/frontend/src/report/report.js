import React, { Component } from "react";
import { ResultQuickview } from "./resultQuickview";
import { Analysis } from "./Analysis";
import "./report.css";
import { Status, Categories } from "../utils/constants";

const data = [
  {
    number: "5.1",
    name: "Registry Configuration Verification",
    status: Status.PASS,
    category: Categories.CONFIG
  },
  {
    number: "5.2",
    name: "Verify GCCS-M User Accounts Created in GL",
    status: Status.PASS,
    category: Categories.CONFIG
  },
  {
    number: "5.3",
    name: "IP Configuration Verification",
    status: Status.FAIL,
    category: Categories.CONFIG,
    splitStatus: {
      ApplicationServer: { status: Status.PASS },
      DatabaseServer: { status: Status.RESOLVED },
      PCWS1: { status: Status.WORKAROUND },
      PCWS2: { status: Status.FAIL },
      PCWS3: { status: Status.PASS }
    }
  },
  {
    number: "5.4",
    name: "Services Verification",
    status: Status.WORKAROUND,
    category: Categories.SERVICES
  },
  {
    number: "5.5",
    name: "Ownship Configuration Verification",
    status: Status.FAIL,
    category: Categories.CONFIG
  },
  {
    number: "5.6",
    name: "Overlays Verification",
    status: Status.PASS,
    category: Categories.SERVICES
  },
  {
    number: "5.7",
    name: "AIF Management Web page Accessibility Verification",
    status: Status.RESOLVED,
    category: Categories.SERVICES
  },
  {
    number: "5.8",
    name: "LINK11 Configuration and Interface Verification",
    status: Status.PASS,
    category: Categories.CONFIG
  },
  {
    number: "6.1",
    name: "DNS Verification",
    status: Status.PASS,
    category: Categories.CONFIG
  },
  {
    number: "6.2.1",
    name: "Aegis /etc/hosts Verification",
    status: Status.PASS,
    category: Categories.CONFIG
  },
  {
    number: "6.2.2",
    name: "Start Tracks Adapter Verification",
    status: Status.PASS,
    category: Categories.SERVICES
  },
  {
    number: "6.2.3",
    name: "Start Aegis-GL Adapter Verification",
    status: Status.PASS,
    category: Categories.SERVICES
  },
  {
    number: "6.2.4",
    name: "GCCS-M/Aegis Display System (ADS) Verification",
    status: Status.PASS,
    category: Categories.SERVICES
  },
  {
    number: "6.3",
    name: "Adaptor NAVSSI Configuration Verification",
    status: Status.RESOLVED,
    category: Categories.CONFIG
  },
  {
    number: "6.4",
    name: "CADRT/TDSS via Serial Verification",
    status: Status.WORKAROUND,
    category: Categories.CONFIG
  },
  {
    number: "6.5",
    name: "SSEE using ESPRIT via Serial Verification",
    status: Status.WORKAROUND,
    category: Categories.CONFIG
  },
  {
    number: "6.6",
    name: "COMMS Interface Verification (CST)",
    status: Status.FAIL,
    category: Categories.MISC
  },
  {
    number: "6.7",
    name: "NFCS Interface Verification (CST)",
    status: Status.PASS,
    category: Categories.MISC
  },
  {
    number: "21",
    name: "Aegis /etc/hosts Verification",
    status: Status.PASS,
    category: Categories.CONFIG
  },
  {
    number: "22",
    name: "Start Tracks Adapter Verification",
    status: Status.PASS,
    category: Categories.SERVICES
  },
  {
    number: "23",
    name: "Start Aegis-GL Adapter Verification",
    status: Status.PASS,
    category: Categories.SERVICES
  },
  {
    number: "24",
    name: "GCCS-M/Aegis Display System (ADS) Verification",
    status: Status.PASS,
    category: Categories.SERVICES
  },
  {
    number: "63",
    name: "Adaptor NAVSSI Configuration Verification",
    status: Status.RESOLVED,
    category: Categories.CONFIG
  },
  {
    number: "64",
    name: "CADRT/TDSS via Serial Verification",
    status: Status.WORKAROUND,
    category: Categories.CONFIG
  },
  {
    number: "65",
    name: "SSEE using ESPRIT via Serial Verification",
    status: Status.WORKAROUND,
    category: Categories.CONFIG
  },
  {
    number: "66",
    name: "COMMS Interface Verification (CST)",
    status: Status.FAIL,
    category: Categories.MISC
  },
  {
    number: "627",
    name: "NFCS Interface Verification (CST)",
    status: Status.PASS,
    category: Categories.MISC
  },
  {
    number: "5.121",
    name: "Registry Configuration Verification",
    status: Status.PASS,
    category: Categories.CONFIG
  },
  {
    number: "5.223",
    name: "IP Configuration Verification",
    status: Status.FAIL,
    category: Categories.CONFIG,
    splitStatus: {
      ApplicationServer: { status: Status.PASS },
      DatabaseServer: { status: Status.RESOLVED },
      PCWS1: { status: Status.WORKAROUND },
      PCWS2: { status: Status.FAIL },
      PCWS3: { status: Status.PASS }
    }
  },
  {
    number: "5.24",
    name: "Services Verification",
    status: Status.WORKAROUND,
    category: Categories.SERVICES
  },
  {
    number: "5.25",
    name: "Ownship Configuration Verification",
    status: Status.FAIL,
    category: Categories.CONFIG
  },
  {
    number: "5.26",
    name: "Overlays Verification",
    status: Status.PASS,
    category: Categories.SERVICES
  },
  {
    number: "5.27",
    name: "AIF Management Web page Accessibility Verification",
    status: Status.RESOLVED,
    category: Categories.SERVICES
  },
  {
    number: "52.8",
    name: "LINK11 Configuration and Interface Verification",
    status: Status.PASS,
    category: Categories.CONFIG
  },
  {
    number: "6.21",
    name: "DNS Verification",
    status: Status.PASS,
    category: Categories.CONFIG
  },
  {
    number: "6.22.1",
    name: "Aegis /etc/hosts Verification",
    status: Status.PASS,
    category: Categories.CONFIG
  },
  {
    number: "6.22.2",
    name: "Start Tracks Adapter Verification",
    status: Status.PASS,
    category: Categories.SERVICES
  },
  {
    number: "6.22.3",
    name: "Start Aegis-GL Adapter Verification",
    status: Status.PASS,
    category: Categories.SERVICES
  },
  {
    number: "6.22.4",
    name: "GCCS-M/Aegis Display System (ADS) Verification",
    status: Status.PASS,
    category: Categories.SERVICES
  },
  {
    number: "62.3",
    name: "Adaptor NAVSSI Configuration Verification",
    status: Status.RESOLVED,
    category: Categories.CONFIG
  },
  {
    number: "6.24",
    name: "CADRT/TDSS via Serial Verification",
    status: Status.WORKAROUND,
    category: Categories.CONFIG
  },
  {
    number: "6.25",
    name: "SSEE using ESPRIT via Serial Verification",
    status: Status.WORKAROUND,
    category: Categories.CONFIG
  },
  {
    number: "6.26",
    name: "COMMS Interface Verification (CST)",
    status: Status.FAIL,
    category: Categories.MISC
  },
  {
    number: "62.7",
    name: "NFCS Interface Verification (CST)",
    status: Status.PASS,
    category: Categories.MISC
  },
  {
    number: "2s1",
    name: "Aegis /etc/hosts Verification",
    status: Status.PASS,
    category: Categories.CONFIG
  },
  {
    number: "2a2",
    name: "Start Tracks Adapter Verification",
    status: Status.PASS,
    category: Categories.SERVICES
  },
  {
    number: "223",
    name: "Start Aegis-GL Adapter Verification",
    status: Status.PASS,
    category: Categories.SERVICES
  },
  {
    number: "242",
    name: "GCCS-M/Aegis Display System (ADS) Verification",
    status: Status.PASS,
    category: Categories.SERVICES
  },
  {
    number: "263",
    name: "Adaptor NAVSSI Configuration Verification",
    status: Status.RESOLVED,
    category: Categories.CONFIG
  },
  {
    number: "624",
    name: "CADRT/TDSS via Serial Verification",
    status: Status.WORKAROUND,
    category: Categories.CONFIG
  },
  {
    number: "652",
    name: "SSEE using ESPRIT via Serial Verification",
    status: Status.WORKAROUND,
    category: Categories.CONFIG
  },
  {
    number: "626",
    name: "COMMS Interface Verification (CST)",
    status: Status.FAIL,
    category: Categories.MISC
  },
  {
    number: "672",
    name: "NFCS Interface Verification (CST)",
    status: Status.PASS,
    category: Categories.MISC
  },

  {
    number: "26.21",
    name: "DNS Verification",
    status: Status.PASS,
    category: Categories.CONFIG
  },
  {
    number: "36.22.1",
    name: "Aegis /etc/hosts Verification",
    status: Status.PASS,
    category: Categories.CONFIG
  },
  {
    number: "46.22.2",
    name: "Start Tracks Adapter Verification",
    status: Status.PASS,
    category: Categories.SERVICES
  },
  {
    number: "56.22.3",
    name: "Start Aegis-GL Adapter Verification",
    status: Status.PASS,
    category: Categories.SERVICES
  },
  {
    number: "66.22.4",
    name: "GCCS-M/Aegis Display System (ADS) Verification",
    status: Status.PASS,
    category: Categories.SERVICES
  },
  {
    number: "6662.3",
    name: "Adaptor NAVSSI Configuration Verification",
    status: Status.RESOLVED,
    category: Categories.CONFIG
  },
  {
    number: "6.254",
    name: "CADRT/TDSS via Serial Verification",
    status: Status.WORKAROUND,
    category: Categories.CONFIG
  },
  {
    number: "6.5425",
    name: "SSEE using ESPRIT via Serial Verification",
    status: Status.WORKAROUND,
    category: Categories.CONFIG
  },
  {
    number: "6.2546",
    name: "COMMS Interface Verification (CST)",
    status: Status.FAIL,
    category: Categories.MISC
  },
  {
    number: "62.547",
    name: "NFCS Interface Verification (CST)",
    status: Status.PASS,
    category: Categories.MISC
  },
  {
    number: "2s541",
    name: "Aegis /etc/hosts Verification",
    status: Status.PASS,
    category: Categories.CONFIG
  },
  {
    number: "2a542",
    name: "Start Tracks Adapter Verification",
    status: Status.PASS,
    category: Categories.SERVICES
  },
  {
    number: "22543",
    name: "Start Aegis-GL Adapter Verification",
    status: Status.PASS,
    category: Categories.SERVICES
  },
  {
    number: "24542",
    name: "GCCS-M/Aegis Display System (ADS) Verification",
    status: Status.PASS,
    category: Categories.SERVICES
  },
  {
    number: "26543",
    name: "Adaptor NAVSSI Configuration Verification",
    status: Status.RESOLVED,
    category: Categories.CONFIG
  },
  {
    number: "62544",
    name: "CADRT/TDSS via Serial Verification",
    status: Status.WORKAROUND,
    category: Categories.CONFIG
  },
  {
    number: "23652",
    name: "SSEE using ESPRIT via Serial Verification",
    status: Status.WORKAROUND,
    category: Categories.CONFIG
  },
  {
    number: "62346",
    name: "COMMS Interface Verification (CST)",
    status: Status.FAIL,
    category: Categories.MISC
  },
  {
    number: "67432",
    name: "NFCS Interface Verification (CST)",
    status: Status.PASS,
    category: Categories.MISC
  },
  {
    number: "236512",
    name: "SSEE using ESPRIT via Serial Verification",
    status: Status.WORKAROUND,
    category: Categories.CONFIG
  },
  {
    number: "623416",
    name: "COMMS Interface Verification (CST)",
    status: Status.FAIL,
    category: Categories.MISC
  },
  {
    number: "674132",
    name: "NFCS Interface Verification (CST)",
    status: Status.PASS,
    category: Categories.MISC
  },
  {
    number: "123652",
    name: "SSEE using ESPRIT via Serial Verification",
    status: Status.WORKAROUND,
    category: Categories.CONFIG
  },
  {
    number: "612346",
    name: "COMMS Interface Verification (CST)",
    status: Status.FAIL,
    category: Categories.MISC
  },
  {
    number: "617432",
    name: "NFCS Interface Verification (CST)",
    status: Status.PASS,
    category: Categories.MISC
  },
  {
    number: "11652",
    name: "SSEE using ESPRIT via Serial Verification",
    status: Status.WORKAROUND,
    category: Categories.CONFIG
  },
  {
    number: "62116",
    name: "COMMS Interface Verification (CST)",
    status: Status.FAIL,
    category: Categories.MISC
  },
  {
    number: "61112",
    name: "NFCS Interface Verification (CST)",
    status: Status.PASS,
    category: Categories.MISC
  }
];

const categoryElementHeight = 25; //height of the category element in pdf
const printMarginX = 15; //to keep elements from being cut off when printing
const printMarginY = 10; //to keep elements from being cut off when printing
const testOffsetMargin = 10; //how much further right the tests are from the category header
const centerTextX = 420; //blaze it. actually the center of the screen
const headerTextY = 30; //lowest y value on page that doesn't cut off the top of text
const firstPageOffsetY = 145; //how far down the first page to put the first test (height of all the elements before it)

//900 is the best value I've found for one page (closest to bottom that never cuts text)
const PAGEHEIGHT = 900; //if tests are being cut off, lowering this should fix, but is mostly likely due to another offset

class Report extends Component {
  constructor(props) {
    super(props);

    //save the full set
    this.fullDataSet = this.props.data || data;
    this.toolbarValues = this.getToolbarValues();

    this.state = {
      page: null,
      data: this.props.data || data,
      expandAll: false
    };
  }

  changePage = page => {
    if (page === null) {
      //changing back to main page
      this.setState({
        page: page,
        data: this.fullDataSet
      });
    } else {
      let filteredData = [...this.state.data];
      filteredData = filteredData.filter(test => {
        return test.status === page;
      });
      console.log(filteredData);
      this.setState({
        page: page,
        data: filteredData
      });
    }
  };

  //Needs to recreate LI's or reuse the remaining LI's
  unwrap = el => {
    // get the element's parent node
    var parent = el.parentNode;

    // move all children out of the element
    while (el.firstChild) parent.insertBefore(el.firstChild, el);

    // remove the empty element
    parent.removeChild(el);
  };

  // Needs to clean up LI elements after putting them all into one OR unwrap needs to insert them back into the LI
  wrapAll = (elms, wrapper) => {
    var el = elms.length ? elms[0] : elms;

    // Cache the current parent and sibling of the first element.
    var parent = el.parentNode;
    var sibling = el.nextSibling;

    // Wrap the first element (is automatically removed from its
    // current parent).
    wrapper.appendChild(el);

    // Wrap all other elements (if applicable). Each element is
    // automatically removed from its current parent and from the elms
    // array.
    while (elms.length) {
      wrapper.appendChild(elms.shift());
    }

    // If the first element had a sibling, insert the wrapper before the
    // sibling to maintain the HTML structure; otherwise, just append it
    // to the parent.
    if (sibling) {
      parent.insertBefore(wrapper, sibling);
    } else {
      parent.appendChild(wrapper);
    }
  };

  //   exportPdf = () => {
  //     const filename = "DiagnosticReport.pdf";

  //     // first expand the tests so that the pdf includes the full report
  //     this.expandAllTests();

  //     const testElems = document.getElementsByClassName("test"); //array of every test
  //     const promises = [];
  //     let elems = [];
  //     let pageHeight = firstPageOffsetY;
  //     let pdf = new jsPDF("l", "pt", "a4");

  //     //create the header and toolbar
  //     pdf.setFontStyle("bold");
  //     pdf.text("Diagnostic Report", centerTextX, headerTextY, {
  //       align: "center"
  //     });
  //     const toolbar = document.querySelector(".toolbar");
  //     let p = html2canvas(toolbar, { scale: 0.75 });
  //     promises.push(p);

  //     //loop through Categories,
  //     //filter testElems for category,
  //     //loop through all the filtered elems,
  //     //include the pageElems loop as a part of this because then the categories will start on new pages
  //     for (let c in Categories) {
  //       let categoryElems = [...testElems].filter(elem => {
  //         return (
  //           elem.parentElement.parentElement.parentElement.id === Categories[c]
  //         );
  //       });

  //       //create the category element without getting all the tests with it
  //       const header = document.getElementById(Categories[c]);
  //       const testListElem = header.childNodes[header.childNodes.length - 1]; //list of tests
  //       let canvas = document.createElement("canvas");
  //       canvas.setAttribute("id", "categoryTitle"); //uses an id to flag this as a category header and not a page of tests
  //       p = html2canvas(header, {
  //         scale: 1,
  //         canvas,
  //         ignoreElements: element => {
  //           return element === testListElem || testListElem.contains(element);
  //         }
  //       });
  //       promises.push(p);

  //       //offset the height of category
  //       pageHeight += categoryElementHeight;

  //       //loop through elements in this category and group together in pages
  //       for (let e in categoryElems) {
  //         let height = categoryElems[e].clientHeight;

  //         if (pageHeight + height >= PAGEHEIGHT) {
  //           // this element wont fit on this page
  //           let wrapper = document.createElement("span");
  //           wrapper.setAttribute("class", "pdfpage" + Categories[c]);
  //           this.wrapAll(elems, wrapper); // wraps all the elements in one span to be rendered into a page
  //           pageHeight = 0;
  //           elems = []; //start new page of elements
  //         }
  //         elems.push(categoryElems[e]);
  //         pageHeight += height;
  //       }

  //       //if there are still leftover elements, wrap the remainders
  //       if (elems.length > 0) {
  //         let wrapper = document.createElement("span");
  //         wrapper.setAttribute("class", "pdfpage" + Categories[c]);
  //         this.wrapAll(elems, wrapper);
  //       }

  //       // render each page as a canvas
  //       const pageElems = document.getElementsByClassName(
  //         "pdfpage" + Categories[c]
  //       ); //grab all the groups of elements
  //       for (let i = 0; i < pageElems.length; i++) {
  //         let p = html2canvas(pageElems[i], {
  //           scale: 0.8,
  //           letterRendering: true
  //         }); //creates a canvas with grouped tests
  //         promises.push(p);
  //       }
  //       elems = [];
  //       pageHeight = 0;
  //     }

  //     console.log(promises);
  //     let titleOffset = 0;
  //     Promise.all(promises)
  //       .then(values => {
  //         for (let i = 0; i < values.length; i++) {
  //           let canvasUrl = values[i].toDataURL("image/jpeg", 1.0);
  //           // The first page is crafted with custom values, after 1st page it is all the same
  //           if (i === 0) {
  //             pdf.addImage(canvasUrl, "JPEG", 0, headerTextY + 10); //add toolbar with 10px margin
  //             pdf.setFontStyle("italic");
  //             pdf.text(
  //               "Analysis",
  //               centerTextX,
  //               headerTextY + 10 + values[i].height,
  //               { align: "center" }
  //             ); //add analysis text just below that
  //           } else if (i === 1) {
  //             //add first category header using first page offset
  //             pdf.addImage(canvasUrl, "JPEG", printMarginX, firstPageOffsetY);
  //           } else if (i === 2) {
  //             //add first test page after that
  //             pdf.addImage(
  //               canvasUrl,
  //               "JPEG",
  //               printMarginX + testOffsetMargin,
  //               firstPageOffsetY + categoryElementHeight
  //             );
  //             pdf.addPage("a4", "l");
  //           }

  //           // After 1st page, can loop through this for however many categories
  //           else {
  //             if (values[i].id === "categoryTitle") {
  //               //category header
  //               pdf.addImage(canvasUrl, "JPEG", printMarginX, printMarginY);
  //               titleOffset = categoryElementHeight;
  //             } else {
  //               pdf.addImage(
  //                 canvasUrl,
  //                 "JPEG",
  //                 printMarginX + testOffsetMargin,
  //                 printMarginY + titleOffset
  //               );
  //               pdf.addPage("a4", "l");
  //               titleOffset = 0; //no longer a page starting with category so reset
  //             }
  //           }
  //         }

  //         pdf.deletePage(pdf.internal.getNumberOfPages()); //delete the extra page at the end
  //         pdf.save(filename);

  //         //clean up the grouped elements created for pdf purposes
  //         for (let c in Categories) {
  //           const wrappers = document.getElementsByClassName(
  //             "pdfpage" + Categories[c]
  //           );
  //           if (wrappers) {
  //             while (wrappers.length > 0) {
  //               this.unwrap(wrappers[0]);
  //             }
  //           }
  //         }
  //       })
  //       .catch(e => console.error(e));
  //   };

  expandAllTests = () => {
    this.setState({
      expandAll: true
    });
  };

  getToolbarValues = () => {
    let result = {};
    for (let s in Status) {
      const data = this.fullDataSet.filter(test => {
        return test.status === Status[s];
      });
      result[Status[s]] = data.length;
    }
    return result;
  };

  render() {
    return (
      <div className="report">
        <header className="header">
          <h1 onClick={this.expandAllTests}>Diagnostic Report</h1>
          <span className="export">
            <i className="fa fa-share-alt-square fa-2x" />
          </span>
        </header>
        <div className="toolbar">
          <ResultQuickview
            values={this.toolbarValues}
            page={this.state.page}
            changePage={this.changePage}
          />
        </div>
        <Analysis tests={this.state.data} expandAll={this.state.expandAll} />
      </div>
    );
  }
}

export default Report;
