class DomNode:
    def __init__(self, id: str, hidden: bool, children: list):
        self.id = id
        self.hidden = hidden
        self.children = children


def find_pop_main(root_node):
    def find_pop(node, parent):
        # if the node is POPUP, set its sibling to hiddent
        # also set the parent siblings to hidden
        for child_new in node.children:
            if child_new.id == 'POPUP':
                for sibling in parent.children:
                    if sibling.id == node.id:
                        continue
                    else:
                        sibling.hidden = True
                for sibling in node.children:
                    if sibling.id == child_new.id:
                        continue
                    else:
                        sibling.hidden = True
                # found the popup, return here
                return True
        # if not, continue the sub-tree
        for child_new in node.children:
            ret_val = find_pop(child_new, node)
            if ret_val:
                return True
        return False

    for child in root_node.children:
        val = find_pop(child, root)
        # found popup with this child
        if val:
            break


if __name__ == "__main__":
    n = DomNode('n', False, [])
    o = DomNode('o', False, [])
    p = DomNode('p', True, [])
    popup = DomNode('POPUP', False, [n, o, p])
    i = DomNode('i', False, [])
    z = DomNode('z', False, [])
    y = DomNode('y', False, [])
    j = DomNode('j', False, [z, y])
    k = DomNode('k', True, [])

    c = DomNode('c', False, [])

    f = DomNode('f', False, [])
    g = DomNode('g', False, [])

    b = DomNode('b', False, [f, g])

    d = DomNode('d', False, [popup, i, j, k])

    root = DomNode('root', False, [b, c, d])

    print(find_pop_main(root))

    print(i.hidden)
    print(j.hidden)
    print(k.hidden)
    print(b.hidden)
    print(c.hidden)