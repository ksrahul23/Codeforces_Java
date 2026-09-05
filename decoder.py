import requests
from bs4 import BeautifulSoup

def decode_secret_message(url):
    # Fetch the HTML content from the published Google Doc
    response = requests.get(url)
    response.raise_for_status()
    
    # Parse the HTML to locate the data table
    soup = BeautifulSoup(response.text, 'html.parser')
    table = soup.find('table')
    
    grid_data = {}
    max_x, max_y = 0, 0
    
    # Extract data from each row, skipping the header row
    for row in table.find_all('tr')[1:]:
        cols = row.find_all('td')
        if len(cols) == 3:
            x = int(cols[0].text.strip())
            char = cols[1].text.strip()
            y = int(cols[2].text.strip())
            
            # Store the character at its specific (x, y) coordinate
            grid_data[(x, y)] = char
            
            # Track the maximum dimensions of the grid
            max_x = max(max_x, x)
            max_y = max(max_y, y)
            
    # Construct and print the grid
    # Since y=0 is the bottom row, we iterate backwards from max_y down to 0
    for y in range(max_y, -1, -1):
        row_chars = []
        for x in range(max_x + 1):
            # Fill with the specified character, or a space if no character exists
            row_chars.append(grid_data.get((x, y), ' '))
        print(''.join(row_chars))

decode_secret_message("https://docs.google.com/document/d/e/2PACX-1vSvM5gDlNvt7npYHhp_XfsJvuntUhq184By5xO_pA4b_gCWeXb6dM6ZxwN8rE6S4ghUsCj2VKR21oEP/pub")