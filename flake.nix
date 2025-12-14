
{
  description = "A very basic flake";

  inputs = { nixpkgs.url = "github:nixos/nixpkgs?ref=nixos-unstable"; };

  outputs = { self, nixpkgs }:
    let pkgs = nixpkgs.legacyPackages.x86_64-linux;
    in {

      devShells.x86_64-linux.default =
        pkgs.mkShell {
          buildInputs = with pkgs; [
            clojure
            leiningen
            clojure-lsp
          ];
          shellHook = ''
            export PS1='\[\e[92m\]nix@\h\[\e[0m\]:\[\e[38;5;129m\]\W\[\e[0m\]\\$ '
                      '';
        };

    };
}
