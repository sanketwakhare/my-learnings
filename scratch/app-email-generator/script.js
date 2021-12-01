const firstNameElement = document.querySelector('#firstName');
const lastNameElement = document.querySelector('#lastName');
const domainNameElement = document.querySelector('#domainName');
const domainExtensionElement = document.querySelector('#domain_extension');

const handleSubmit = () => {

    // prevent event defaults
    event.preventDefault();

    // extract input fields
    const firstName = firstNameElement.value.toLowerCase();
    const lastName = lastNameElement.value.toLowerCase();
    const domainName = domainNameElement.value.toLowerCase();
    const domain = domainExtensionElement.value.toLowerCase();

    // generate patterns
    let patterns = [];
    patterns.push(`${firstName}${lastName}@${domainName}${domain}`);
    patterns.push(`${firstName}_${lastName}@${domainName}${domain}`);
    patterns.push(`${firstName.charAt(0)}${lastName}@${domainName}${domain}`);
    patterns.push(`${firstName.charAt(0)}.${lastName}@${domainName}${domain}`);
    patterns.push(`${firstName.charAt(0)}_${lastName}@${domainName}${domain}`);
    patterns.push(`${firstName}@${domainName}${domain}`);
    patterns.push(`${lastName}@${domainName}${domain}`);
    patterns.push(`${lastName}${firstName}@${domainName}${domain}`);
    patterns.push(`${lastName}.${firstName.charAt(0)}@${domainName}${domain}`);
    patterns.push(`${lastName.charAt(0)}${firstName}@${domainName}${domain}`);
    patterns.push(`${lastName.charAt(0)}.${firstName}@${domainName}${domain}`);
    patterns.push(`${lastName.charAt(0)}_${firstName}@${domainName}${domain}`);
    patterns.push(`${firstName}${lastName.charAt(0)}@${domainName}${domain}`);
    patterns.push(`${firstName}.${lastName.charAt(0)}@${domainName}${domain}`);
    patterns.push(`${firstName}_${lastName.charAt(0)}@${domainName}${domain}`);


    // remove all event listeners
    const outputElement = document.querySelector('#output');
    outputElement.removeAttribute('class');
    while (outputElement.hasChildNodes()) {
        outputElement.removeChild(outputElement.childNodes[0]);
    }


    // create div elements for all patterns
    // let outContainer = document.createElement('div');
    patterns.forEach((currentEmailPattern, index) => {
        let patternContainer = document.createElement('div');
        patternContainer.className = 'pattern-container';
        // patternContainer.innerHTML = currentEmailPattern;

        // labels for email patterns
        let emailContainer = document.createElement('strong');
        emailContainer.setAttribute('id', 'email-' + index);
        emailContainer.innerText = currentEmailPattern;
        emailContainer.setAttribute('value', currentEmailPattern);
        emailContainer.className = 'pattern-container';
        patternContainer.appendChild(emailContainer);

        // copy button for email pattern
        let copyBtn = document.createElement('input');
        copyBtn.setAttribute('id', 'btn-copy-' + index);
        copyBtn.setAttribute('value', 'Copy');
        copyBtn.setAttribute('type', 'button');
        copyBtn.addEventListener('click', handleCopy);
        copyBtn.className = 'pattern-container';
        patternContainer.appendChild(copyBtn);

        outputElement.appendChild(patternContainer);
    });

    outputElement.setAttribute('class', 'box');

}


/**
 * Copy label text: email id to clipboard
 * @param {Event} event 
 */
const handleCopy = (event) => {
    const textCopied = event.target.parentElement.innerText;
    /* Copy the text on clip board */
    navigator.clipboard.writeText(textCopied);


}